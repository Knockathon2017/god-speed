var express = require('express');

var app = express();
var path    = require("path");

app.use(express.static('public'));

app.listen(3000, function(){
    console.log("Express is up and running on port 3000.");
});

app.get('/log',function(req,res){
    res.sendFile(path.join(__dirname+'/public/socket.html'));
    //__dirname : It will resolve to your project folder.
});