Main github account: https://github.com/Dheeraj9811/
** Deliverable:
1) Host the APIs and share URL:

	a) Display current week leaderboard(Top 200):
		"https://blacklight-dheeraj-2020194.onrender.com/lb/cw"
	b) Display last week leaderboard given a country by the user(Top 200):
		"https://blacklight-dheeraj-2020194.onrender.com/lb/lw/{enter contry 2 digit code}" 

	c)  Fetch user rank, given the userId: 
		"https://blacklight-dheeraj-2020194.onrender.com/ur/{add user id}"

*Note: The server has a maximum connection limit of 10 and may crash. The activation link limit is set to a maximum of 5 days.**

code for this repo(alternative account is used):"https://github.com/Itachi9811/Api_Task"
_______________________________________________________________________________________________________________
_______________________________________________________________________________________________________________


** if you want to run local , run cmd "npm i"
then run 
a)	"http://localhost:5173//lb/cw"
b) 	"http://localhost:5173/lb/lw/{enter contry 2 digit code}" 
c)	"http://localhost:5173/ur/{add user id}"
_______________________________________________________________________________________________________________
_______________________________________________________________________________________________________________


**Important:**
- The actual SQL database is hosted on freesqldatabase, and the Node server is hosted on Render.
- Be cautious of the connection and activation link limits.

sql stuture
 There is table Name= 'leaderboard' which contains
• UID (String)
• Name (String)
• Score (Integer)
• Country (ISO 2 letter country code)
• TimeStamp (timestamp)

_______________________________________________________________________________________________________________