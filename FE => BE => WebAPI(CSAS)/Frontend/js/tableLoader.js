//URL
const requestURLuserDBTrue = 'http://localhost:8080/api/getList?userdb=1';
const requestURLuserDBFalse = 'http://localhost:8080/api/getList?userdb=0';

//Variables for table drawing
let tableBody = document.getElementById("exchangeTableBody");
let tableData = []; //This variable for Search function

//Gets data and draws table from it
const drawTable = (data) =>{
    let html = "";
    //Get Data
    data.forEach(element => {
        html += "<tr>" + "<td>" +element.version + "</td>" +
                        "<td>" +element.country+ "</td>" +
                        "<td>" +element.name + "</td>" +
                        "<td>" +element.shortName + "</td>" +
                        "<td>" +element.validFrom + "</td>" +
                        "<td>" +element.amount + "</td>" +
                        "<td>" +element.valBuy + "</td>" +
                        "<td>" +element.valSell + "</td>" +
                        "<td>" +element.valMid + "</td>" +
                        "<td>" +element.currBuy + "</td>" +
                        "<td>" +element.currSell + "</td>" +
                        "<td>" +element.currMid + "</td>" +
                        "<td>" +element.move + "</td>" +
                        "</tr>";
    });
    //Draws it
    tableBody.innerHTML = html;
}

//This function is called by green "UserDB param: True"  Button
const userDBTrueButton = () =>{
    sendRequest(requestURLuserDBTrue, 'GET')
    .then(data => onSuccessRequest(data) )
    .catch(err => onBadRequest());
}


//This function is called by red "UserDB param: False"  Button
const userDBFalseButton = () =>{
    sendRequest(requestURLuserDBFalse, 'GET')
    .then(data => onSuccessRequest(data) )
    .catch(err => onBadRequest());
}

//Searches data from search line
const searchBySearchLine = () => {
    let searchLine = document.getElementById("searchLine").value;
    let newDataTable = tableData.filter(function(e){
        return e.country.toLowerCase().indexOf(searchLine.toLowerCase()) >= 0;  
    });
    clearSearchLine();
    drawTable(newDataTable);
}

//Clears search line
const clearSearchLine = () => {
    document.getElementById("searchLine").value = null;
}

//Async function - fetching data from Server
const sendRequest = async (url, method, body = null) => {
    return await fetch(url).then(response => { 
        return response.json() 
    })
}

//Gets data and call drawTable function
const onSuccessRequest = (data) => {
    tableData = data;
    drawTable(data);
}

//Redirects to error page if promise (function sendReques) cathed error
const onBadRequest = () => {
    window.location.replace("error.html");
}

//Calls sendRequest function and 
sendRequest(requestURLuserDBTrue, 'GET')
.then(data => onSuccessRequest(data) )
.catch(err => onBadRequest());