git 
Git-2.36.1-64-bit
Creact repository get url{https://github.com/kreshan882/SpringBootH2JspWebBknSimulator.git}
1) git Gui
	>[git config --global user.email "kreshan882@gmail.com"]
	clone exesit repository [ URL  +  LocalPath/newFolder + clone]
	git clone url
	
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
2) Run As-> Mvn Build
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
		
		

		
		

	