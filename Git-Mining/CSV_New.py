import pandas as pd
from datetime import datetime
from pydriller import Repository
from pydriller.metrics.process.change_set import ChangeSet
from pydriller.metrics.process.code_churn import CodeChurn
from pydriller.metrics.process.contributors_count import ContributorsCount
from pydriller.metrics.process.hunks_count import HunksCount

singleMode = True
format = "%Y-%m-%d %H:%M:%S"

# Process git commit and export to csv file
def Git_Test():
    gitURL = 'https://ebeisea@gerrit.ericsson.se/a/OSS/ENM-Parent/SQ-Gate/com.ericsson.graduates/project-d16'
    startDate = '2022-09-30 09:00:00'
    endDate = '2022-10-3 14:00:00'
    Git_Processing(gitURL, startDate, endDate)

# Validate Git and iniate request
def Git_Processing(gitURL, startDate, endDate):
    # Intake dateTime arguements
    startDate = datetime.strptime(startDate, format)
    endDate = datetime.strptime(endDate, format)
    # initiate dataFrame
    commitDataframe = pd.DataFrame(columns=['Date','Contributor Name','Contributor Email', 'Lines Added', 'Lines Removed', 'Files Committed', 'Hash'])
    
    try:
        #Get commits and populate dataFrame
        for commit in Repository(gitURL, since=startDate, to=endDate).traverse_commits():
            commitDataframe.loc[len(commitDataframe.index)] = [commit.committer_date,commit.committer.name,commit.committer.email,commit.insertions,commit.deletions,commit.files,commit.hash]
            ProjectName = commit.project_name

        if (len(commitDataframe.index) > 0):

            if(singleMode == False):
                # Append commits to file
                commitDataframe.to_csv('.\CSV_Files/'+ProjectName+'-Commits.csv',mode='a', index=False, header=False)
                # Get all commits to complete analysis
                commitDataframe = pd.read_csv('.\CSV_Files/'+ProjectName+'-Commits.csv')
            get_Info(gitURL, commitDataframe, ProjectName)
        else:
            print("No latest update")
    
    except Exception:
        #Show exception
        traceback_output = traceback.format_exc()
        print(traceback_output)

    return ProjectName


def get_Info(gitURL, commitDataframe, ProjectName):
        infoDataFrame =  pd.DataFrame(columns=['Project','Initial Commit','Latest Commit','Commits Num', 'Lines Added', 'Lines Removed', 'Change Set Avg', 'Change Set Max', 'Churn Count', 'Churn Max', 'Churn Avg', 'Contributers Count', 'Contributers Minor','Hunks'])
            
        #Get Commit Hashes and Number of Commits
        initalCommit = commitDataframe['Hash'].iloc[0]
        latestCommit = commitDataframe['Hash'].iloc[len(commitDataframe.index)-1]
        numberCommit = len(commitDataframe.index)

        #Count Number of lines added/deleted
        linesAdded = commitDataframe['Lines Added'].sum()
        linesRemoved = commitDataframe['Lines Removed'].sum() 

        #Get Changeset metrics
        metric = ChangeSet(path_to_repo=gitURL, from_commit=initalCommit, to_commit=latestCommit)
        changeSetMax = metric.max()
        changeSetAvg = metric.avg()

        #Get CodeChurn Metrics
        metric = CodeChurn(path_to_repo=gitURL, from_commit=initalCommit, to_commit=latestCommit)
        churnCount = metric.count()        
        churnMax = metric.max()
        churnAvg = metric.avg()

        #Get Contributor Metrics
        metric = ContributorsCount(path_to_repo=gitURL, from_commit=initalCommit, to_commit=latestCommit)
        contributorCount = metric.count()
        contributorMinor = metric.count_minor()

        #Get Hunks Metrics
        metric = HunksCount(path_to_repo=gitURL, from_commit=initalCommit, to_commit=latestCommit)
        hunksCount = metric.count()

        #Initalise Empty arrays
        tempChurnCount, tempChurnMax, tempChurnAvg, tempContributorCount, tempContributorMinor, tempHunksCount = ([] for i in range(6))

        #Loop through generated arrays extracting values
        for key in churnCount.keys() :
            tempChurnCount.append(churnCount[key])
            tempChurnMax.append(churnMax[key])
            tempChurnAvg.append(churnAvg[key])
            #Check keys for parity
            if key in contributorCount:
                tempContributorCount.append(contributorCount[key])
                tempContributorMinor.append(contributorMinor[key])
            if key in hunksCount:
                tempHunksCount.append(hunksCount[key])

        #Calculate necessary values for info file
        churnCount = sum(tempChurnCount)
        churnMax = max(tempChurnMax)
        churnAvg = sum(tempChurnAvg)/len(tempChurnAvg)
        contributorCount = sum(tempContributorCount)
        contributorMinor = sum(tempContributorMinor)
        hunksCount = sum(tempHunksCount)

        #Append info Dataframe
        infoDataFrame.loc[len(infoDataFrame.index)] = [ProjectName, initalCommit, latestCommit, numberCommit, linesAdded, linesRemoved, changeSetAvg, changeSetMax, churnCount, churnMax, churnAvg, contributorCount, contributorMinor, hunksCount]
    
        #Output dataFrames to csv files
        commitDataframe.to_csv(r'.\CSV_Files/'+ProjectName+'-Commits.csv', index = False)
        infoDataFrame.to_csv(r'.\CSV_Files/'+ProjectName+'-Info.csv', index = False)
        

def csv_reader():
        #Get history file
        csvFile = pd.read_csv('./CSV_Files/Git-history.csv')

        
        if(singleMode):
            row = csvFile.tail(1)
            #Process latest line added
            ProjectName = Git_Processing(row['Git'][0],str(row['start date'][0]),str(row['end date'][0]))
            now = datetime.now()
            #Update latest update field
            csvFile.loc[csvFile.index[-1], 'last update'] = now.strftime(format)
            csvFile.loc[csvFile.index[-1], 'Project'] = ProjectName
            #Update file
            csvFile.to_csv("./CSV_Files/Git-history.csv", index=False)
        else:
            #Iterate through gits
            for idx, row in csvFile.iterrows():
                now = datetime.now()
                #process git
                ProjectName = Git_Processing(row['Git'],str(row['last update']),str(now.strftime(format)))
                now = datetime.now()
                #Update latest update field
                csvFile.loc[idx,'last update'] = str(now.strftime(format))
                csvFile.loc[idx, 'Project'] = ProjectName
            #Update file
            csvFile.to_csv("./CSV_Files/Git-history.csv", index=False)

#Call CSV reader to initiate processing
csv_reader()


