##TASK PAGE
### *-for ZNevzz only*

**07-05-2016**
<br/>
**NOTIFICATIONS MODULE**
<br/>
**1.Create beans for Notification, NotificationRoot**
<br/>
**2.Change corresponding Service,ServiceImpl using CopyProperties and return Bean instead of model**
<br/>
**3.Add userName,branch,roleId checking criteria in ServiceImpl**
<br/>
**4.a.delete dateTime, add date, time, url fields in model.Notification**
<br/>
**4.b.Add sort method -- sort according to date and time in descending order "use Randomized Quicksort in compare()"**
<br/>
5.Add authorization -*will do later or keep written in comments*
<br/>
6.Write logic for AJAX Call
<br/>
**7.Write "Add notification" logic.**
<br/>
8.Call the add notification logic at appropriate places
<br/>
9.Also integrate Email Notification wherever required
<br/>

**LOGIN MODULE**

**1.When user logs in, set UserDetails table fields**

**2.When user logs out,Invalidate Session and update UserDetails table fields**


**EXCEPTION HANDLING MODULE**

**1.Handle Null pointer and other exceptions(demo in logged-out url)**

**FEEDBACK MODULE**
<br/>
1.Sort view Feedback into 3 lists : Student feedback, Faculty feedback, TPO feedback
<br/>
2.Integrate FORM UI feedback.jsp
<br/>
3.Integrate VIEW FEEDBACKS UI feedbacks.jsp
<br/>


**EXPORT AS CSV MODULE**
<br/>
1.Write an Service interface
<br/>
2.Select a module to be exported as CSV
<br/>
3.Write ImplService class for that module
<br/>
4.Connect Download module
<br/>

**ADMIN METHODS**
<br/>
1.List down all tables which require ADMIN INTERVENTION
<br/>
2.Allot module to developers to write CRUD operations
<br/>

**TASKS FOR FINAL PRESENTATION**
<br/>
1.Spring Remoting
<br/>
2.UI Integration
<br/>
3.Testing
<br/>
4.Online Deployment
<br/>
5.Login module with LDAP
<br/>
6.Decide working modules, and present to client/mentor. Document changes to be done via review
<br/>

**08-05-2016**
<br/>
**TASKS FOR developers**
<br/>
1.Add @author, @params, @return in each module written. Also mention the dependencies i.e. class files which the current class file depends on.
<br/>
2.Document testing for blank,invalid and correct inputs for all forms with Screen-shots
<br/>
3.Write algorithm applied for every method defined in module
<br/>


**TASKS FOR designers**
<br/>
1.Add @author in jsp pages
<br/>
2.Add Controller names which interact with jsp, alongwith the URLs
<br/>
3.Mention @author in any JQuery added by individual
<br/>

**VIEW PROFILE MODULE**
<br/>
1. Add and display Qualification of User on Profile page
<br/>

**SEARCH USER MODULE**

1.Add JQUERY to append results as an list with href url

2.Logic of redirecting href url to person's profile page

**PROJECT MANAGEMENT LIFE CYCLE STRATEGY**

*Needs of the hour: *

1.UI Integration

2.Refactor invalid, incomplete, unlinked modules

3.Add new modules

4.Remoting

5.Deployment as WAR and on linux machine

6.Unit, Integration, System Testing

>ACTION PLAN: Division of tasks-

**TEAM 1**:Version1 TEAM

-Proceeding ahead with current version of project i.e. version 1

-Presentation of version1 to stakeholders and owners & collecting review for changes in version 2

-Deployment planning and execution either on PaaS or Linux machine

-Using Spring Remoting & establishing Web Server and App Server modules


