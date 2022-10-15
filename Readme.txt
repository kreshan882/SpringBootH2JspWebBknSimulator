git 
Git-2.36.1-64-bit
Creact repository get url{https://github.com/kreshan882/SpringBootH2JspWebBknSimulator.git}
1) git Gui
   ======================================
   get file from Git BAST commant font
   ======================================
	git config --global user.email "kreshan882@gmail.com"
	cd D://PROJECTS//ECLIPES_K//PERSONAL_SPRINGBOOT//
	git clone https://github.com/kreshan882/SpringBootH2JspWebBknSimulator.git
	
	================================
	upload Git BAST commant font
	================================
	git config --global user.email "kreshan882@gmail.com"
	cd TestBknSimulatorH2SpringBoot/
	git init
	git add src/* (git add --all)
	git status  ==> check status 
	git commit -m "commit fst"
	git log
	git push https://github.com/kreshan882/SpringBootH2JspWebBknSimulator.git
	
	
=====================================
RUN
=====================================
Open Spring Tool Suite 4
OPEN JSP design===> 
		 window - preferences - general - editors - file associations
		 File Type(*.Jsp)
		 Associate Editor(Java editor) --> applay
		 
1) create new spring boot project to add libeary automatic
	new -> spring start project -> demoK -> 3.0.0 shaper -> h2 database+ Spring Web 

2) open project form git
	application.properties
	banner.txt
	data.sql -> loaded this sql automatically
2) Run As-> Mvn Build -> clean package
3) RunAs -> Spring Boot App
4) H2 Database ===> http://localhost:8888/h2/
		Generic H2 (Embedded)
		org.h2.Driver
		jdbc:h2:mem:testdb
		IBL_D_SIM/IBL_D_SIM
4) Web ==> http://localhost:8888/Login
		Just Login
		Add + Delete
		Modify ???
		
5) jsp bug fix
  5.1) RUN-> %TEMP%
       C:\Users\kreshan.r\AppData\Local\Temp\tomcat.3990816478800102839.8888\work\Tomcat\localhost\ROOT\org\apache\jsp

  5.2) put jsp comment proporly
		
		

	