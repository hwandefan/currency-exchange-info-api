# currency-exchange-info-api
<b>2 Projects (Frontend -> API / Frontend -> Backend -> API) which get and handle info about currency.</b> 
<hr />

<b>Frontend part INFO:</b> <br />
<p>The project has 2 Frontend parts (Projects). First part takes currency info from CSAS Server (WebAPI). Second part sends "GET" request with param and works with backend part of project.</p> 
<hr />
<b>Backend part INFO:</b> <br />
<p>Backend part receives requests from Frontend and handles it. It works with Database and WebAPI (CSAS Server). If received param is "true"(true, 1, YES) then it takes data from DB. If DB is empty, it takes data from WebAPI and write the data to DB. If received param is "false"(false, 0, NO) it takes data from WebAPI and write the data to DB.</p> 
<hr />
<b>Database INFO:</b> <br />
<p>Project was built on postgres db. You can download it <a href="https://www.postgresql.org/">HERE</a>. <br />
  And then you need to create DB with name: <b>exchange_info_postgres_db</b> <br /><br />
<b>Or if you have 'docker', you can install DB following this commands in terminal:</b> <br />
1) docker run --name <YOUR NAME> -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres<br />
2) docker exec -it <YOUR NAME> bin/bash<br />
3) psql -U postgres<br />
4) CREATE DATABASE exchange_info_postgres_db;<br /><br />
  <b>You can choose your own database:</b><br />
If you want to install your own DB, you need to change in <b>resources/application.properties: "Hibernate Property - spring.jpa.properties.hibernate.dialect=*YOUR DB DIALECT*"</b>, to dialect for your DB.
</p>

