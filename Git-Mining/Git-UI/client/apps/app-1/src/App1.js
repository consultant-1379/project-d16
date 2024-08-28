/**
 * App1 is defined as
 * `<e-app-1>`
 *
 * Imperatively create application
 * @example
 * let app = new App1();
 *
 * Declaratively create application
 * @example
 * <e-app-1></e-app-1>
 *
 * @extends {App}
 */
import { definition } from '@eui/component';
import { App, html } from '@eui/app';
import '@eui/table';
import style from './app1.css';

@definition('e-app-1', {
  style,
  props: {
    response: { attribute: false },
    columns: { type: Array, default: [] },
    data: { type: Array, default: [] },
    git_columns: { type: Array, default: [] },
    git_data: { type: Array, default: [] },
  },
})
export default class App1 extends App {

link = "";
startDate = ""
endDate = ""
history = null

_add(){
    let analysis = this.shadowRoot.getElementById("git_analysis");
    console.log(this.link+'\n'+this.startDate+'\n'+this.endDate);
    var theUrl = "http://localhost:8000/gitHistory/add/"+this.link+"_"+this.startDate+"_"+this.endDate
    fetch(theUrl, {method: "POST"})
    /*.then(res => res.json())
    .then(function(data) {

    })*/
    .catch(e => console.log(e))

     analysis.innerHTML = `
        <div class="git__row">
            <div class="git__col-4 git__col"></div>
            <div class="git__col-4 git__col git__center">
                <eui-base-v0-loader size="large"></eui-base-v0-loader>
            </div>
        </div>
     `;
 }

_open(){
    let analysis = this.shadowRoot.getElementById("git_analysis");
    analysis.innerHTML = `
        <div class="git__row">
           <div class="git__col-1-xs git__col-2-sm git__col-2-lg"></div>
           <div class="git__col-6 git__col">
                <h1 id="git_ProjectName">Project-D16 <eui-base-v0-button @click='${() => this._clear()}'>Clear</eui-base-v0-button></h1>
           </div>
        </div>
        <div class="git__row">
           <div class="git__col-1-xs git__col-2-sm git__col-2-lg"></div>
           <div class="git__col-5-xs git__col-4-sm git__col-2-md git__col">
                <eui-layout-v0-card card-title="Commits" subtitle="lorem ipsum">
                </eui-layout-v0-card>
           </div>
           <div class="git__col-5-xs git__col-4-sm git__col-2-md git__col">
               <eui-layout-v0-card card-title="Lines Added" subtitle="lorem ipsum">
               </eui-layout-v0-card>
           </div>
           <div class="git__col-1-xs git__col-2-sm git__col-0-md"></div>
           <div class="git__col-5-xs git__col-4-sm git__col-2-md git__col">
              <eui-layout-v0-card card-title="Lines Removed" subtitle="lorem ipsum">
              </eui-layout-v0-card>
           </div>
           <div class="git__col-5-xs git__col-4-sm git__col-2-md git__col">
            <eui-layout-v0-card card-title="Change Set Avg" subtitle="lorem ipsum">
            </eui-layout-v0-card>
           </div>
        </div>

        <div class="git__row">
           <div class="git__col-1-xs git__col-2-sm git__col-2-lg"></div>
           <div class="git__col-5-xs git__col-4-sm git__col-2-md git__col">
                <eui-layout-v0-card card-title="Change Set Max" subtitle="lorem ipsum">
                </eui-layout-v0-card>
           </div>
           <div class="git__col-5-xs git__col-4-sm git__col-2-md git__col">
               <eui-layout-v0-card card-title="Churn Size" subtitle="lorem ipsum">
               </eui-layout-v0-card>
           </div>
           <div class="git__col-1-xs git__col-2-sm git__col-0-md"></div>
           <div class="git__col-5-xs git__col-4-sm git__col-2-md git__col">
              <eui-layout-v0-card card-title="Churn Avg" subtitle="lorem ipsum">
              </eui-layout-v0-card>
           </div>
           <div class="git__col-5-xs git__col-4-sm git__col-2-md git__col">
            <eui-layout-v0-card card-title="Churn Max" subtitle="lorem ipsum">
            </eui-layout-v0-card>
         </div>
        </div>
        <div class="git__row">
           <div class="git__col-1-xs git__col-2-sm git__col-2-lg"></div>
           <div class="git__col-5-xs git__col-4-sm git__col-2-md git__col">
                <eui-layout-v0-card card-title="Contributors" subtitle="lorem ipsum">
                </eui-layout-v0-card>
           </div>
           <div class="git__col-5-xs git__col-4-sm git__col-2-md git__col">
               <eui-layout-v0-card card-title="Contributors Minor" subtitle="lorem ipsum">
               </eui-layout-v0-card>
           </div>
           <div class="git__col-1-xs git__col-2-sm git__col-0-md"></div>
           <div class="git__col-5-xs git__col-4-sm git__col-2-md git__col">
              <eui-layout-v0-card card-title="Hunks Count" subtitle="lorem ipsum">
              </eui-layout-v0-card>
           </div>
        </div>
        </br></br>
        <div class="git__row">
            <div class="git__col-1"></div>
            <div class="git__col-6 git__col">
                <h2>Commits</h2>
            </div>
        </div>
        <div class="git__row">
            <div class="git__col-1"></div>
            <div class="git__col-10 git__col">
                <eui-table-v0  style="height: 300px" .data=${this.git_data} .columns=${this.git_columns} striped>
                </eui-table-v0>
            </div>
          </div>
    `;

}

_clear(){
    console.log("Got Here");
    let analysis = this.shadowRoot.getElementById("git_analysis");
    analysis.innerHTML = ``;

}

async _get(link){
    var theUrl = "http://localhost:8000/gitHistory/get"
     const res = await fetch(theUrl, {
    method: "POST",
  headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  },
  //mode: 'no-cors',
    body: JSON.stringify(link)//link.substring(1,link.length - 1))
    })
    this.history = await res.json();
    console.log(this.history)

 }

async _delete(link){
    var theUrl = "http://localhost:8000/gitHistory/delete"
     const res = await fetch(theUrl, {
    method: "POST",
  headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  },
    body: JSON.stringify(link)
    })
    this.history = await res.json();
    console.log(this.history)
 }

 _hi(){
 console.log("HI")
 }

  // Uncomment this block to add initialization code
   constructor() {
     super();
  //   // initialize
    this.columns = [
            { title: 'Project', attribute: 'col1', sortable: true },
            { title: 'Link', attribute: 'col2', sortable: true },
            { title: 'Latest Update', attribute: 'col3', sortable: true }
          ];

    this.git_columns = [
        { title: 'Date', attribute: 'col1', sortable: true },
        { title: 'Contributor', attribute: 'col2', sortable: true },
        { title: 'Email', attribute: 'col3', sortable: true },
        { title: 'Lines Added', attribute: 'col4', sortable: true },
        { title: 'Lines Removed', attribute: 'col5', sortable: true },
        { title: 'Files Committed', attribute: 'col6', sortable: true },
        { title: 'Hash', attribute: 'col7', sortable: true }
      ];

    this.data = [
        { col1: 'test-project', col2: 'https://github.com/ishepard/pydriller.git', col3: '2022-10-05 09:00:00'},
        { col1: 'Item 2', col2: 'Details 2', col3: 'Details 2'},
        { col1: 'Item 3', col2: 'Details 3', col3: 'Details 3'},
        { col1: 'Item 4', col2: 'Details 4', col3: 'Details 4'},
        { col1: 'Item 5', col2: 'Details 5', col3: 'Details 5'},
        { col1: 'Item 6', col2: 'Details 6', col3: 'Details 6'},
      ];
  }

  addNotification(menuItemLabel, row) {
      const notification = document.createElement('eui-base-v0-notification');
      notification.description = `${menuItemLabel} action selected for the following row:
        ${JSON.stringify(row)}`;
      notification.textContent = 'Menu Item Clicked';
      notification.timeout = 3000;
      notification.showNotification();
    }

  /**
   * Handle events
   *
   * @function handleEvent
   * @param {Event} event
   */
  handleEvent(event) {

    if (event.type === 'eui-table:contextmenu') {
          this.contextRow = event.detail.row;
          event.detail.menu.show = true;
        }
     if (event.type === 'eui-menuItem:click') {
           switch(event.target.value) {
             case 'view':
               this.addNotification('View', this.contextRow);
               break;

             case 'sync':
               this.addNotification('Sync', this.contextRow);
               break;

             case 'delete':
               this.addNotification('Delete', this.contextRow);
               break;
           }
    }
  }

  /**
   * Render the <e-todo> app. This function is called each time a
   * prop changes.
   */
  render() {

    return html`
      <div class="git_search">
          <div class="git__row">
          <div class="git__col-1"></div>
          <div class="git__col-6 git__col">
              <h1>Git Search</h1>
          </div>
        </div>
          <div class="git__row">
              <div class="git__col-1 git__col"></div>
              <div class="git__col-4 git__col">
                  <label class="git__date-field">Start Date</label>
              </div>
              <div class="git__col-4 git__col">
                  <label class="git__date-field">End Date</label>
              </div>
          </div>
          <div class="git__row">
              <div class="git__col-1 git__col"></div>
              <div class="git__col-4 git__col">
                  <eui-base-v0-datepicker
                      id="git-startdate"
                      class="git__datepicker"
                      @eui-datepicker:change="${(event) => this.startDate = event.detail.date}"
                  ></eui-base-v0-datepicker>
              </div>
              <div class="git__col-4 git__col">
                  <eui-base-v0-datepicker
                      id="git-enddate"
                      @eui-datepicker:change="${(event) => this.endDate = event.detail.date}"
                  ></eui-base-v0-datepicker>
              </div>
          </div>
          <div class="git__row">
            <div class="git__col-1 git__col"></div>
            <div class="git__col-6 git__col">
                <eui-base-v0-text-field
                                  id="git-entry"
                                  class="git__search-field"
                                  placeholder="Enter git"
                                  fullwidth
                                  @change="${(event) => this.link = event.detail.value}"
                                >
                </eui-base-v0-text-field>
            </div>
            <div class="git__col-1 git__col">
                <eui-base-v0-button
                  @click='${() => this._add(this.link)}'
                  primary
                  fullwidth
                  >Analyse</eui-base-v0-button>
            </div>
          </div>
      </div>
      </br></br>

        <div id="git_analysis"></div>

      </br></br>
      <div class="git_history">
          <div class="git__row">
            <div class="git__col-1"></div>
            <div class="git__col-6 git__col">
                <h1>Analysis History</h1>
            </div>
          </div>
          <div class="git__row">
            <div class="git__col-1"></div>
            <div class="git__col-10 git__col">
                <eui-table-v0  style="height: 300px" .data=${this.data} .columns=${this.columns} @eui-table:contextmenu=${this} striped>
                    <eui-base-v0-menu slot='context-menu' id='actions-menu'>
                        <eui-base-v0-menu-item value='view' label='View' @eui-menuItem:click=${this._get}>
                          <eui-v0-icon name='eye' slot='left'></eui-v0-icon>
                        </eui-base-v0-menu-item>
                        <eui-base-v0-menu-item value='sync' label='Sync' @eui-menuItem:click=${this}>
                          <eui-v0-icon name='reload' slot='left'></eui-v0-icon>
                        </eui-base-v0-menu-item>
                        <eui-base-v0-menu-item value='delete' label='Delete' @eui-menuItem:click=${this}>
                          <eui-v0-icon name='trashcan' slot='left'></eui-v0-icon>
                        </eui-base-v0-menu-item>
                      </eui-base-v0-menu>
                </eui-table-v0>
            </div>
          </div>
      </div>
    `;
  }
}

/**
 * Register the component as e-app-1.
 * Registration can be done at a later time and with a different name
 * Uncomment the below line to register the App if used outside the container
 */
// App1.register();
