## Most Popular Articles Application
This application have 2 Screens first you will see list of Most Popular Articles and then when you click on single item you will go to next screen and will se detail of that application

In this application I used MVVM architecture and repository file for network call for adding another abstraction layer. And I used databinding for views
In this application for transection I used navigation editor from on fragment to another
For network call retrofit is used
## This application have main 7 packages
- Adapters have adapter for Recycler View used to display dynamic Articles
- Api have 2 class and on interface which includes retrofit client and Api functionalities.
- Model packages includes all the model class for mapping data from json to class using Gson library.
- repository contains singleton class for network call.
- utils have different class to manage network stats and call back method interface.
- view contains fragments and activity.
- viewmodel contains viewmodel for this application.
## Flow of this Application
First Activity MostPopularArticleActivity.class launched in this activity I have implemented navigation editor and the starting fragment is MostPopularArticleListFragment.call attached.
In this fragment I have implemented databinding and on activity life cycle i have attached Viewmode of MostPopularArticleViewModel.class.
and I call fucntion to get Articles list which is getPopularArticles.
In onActivityCreated I am observing getPopularArticlesData function which retuns MutableLiveData.
In ViewModel getPopularArticles function executing function of getMostOpularArticles function from Repository file which return data in success case and error in error case.
In Repository is actually network call to get data from server.
## How to Test
- You can clone this repository from GitHub and open it in Android studio and run this project on you emulator or real device it will run fine and check code also.
- And you can download apk file from rood folder of this repository named testDebug.apk
