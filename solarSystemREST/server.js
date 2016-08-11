
var express = require('express'),
    weather = require('./managers/weathers'),
	mongoose = require('mongoose'),
	fs = require('fs');
	

// Database configuration
// =============================================================================
var mongoUri = 'mongodb://martino:martino@ds147995.mlab.com:47995/solardatabase';
//var mongoUri = 'mongodb://localhost:27017/solardatabase';
mongoose.connect(mongoUri);
console.info('1 mongoose.connect(mongoUri);');
var db = mongoose.connection;

db.on('error', function () {
  throw new Error('unable to connect to database at ' + mongoUri);
});


// Define the schemas
var Weather = require('./models/weather');


db.once('open', function () {
  console.info('connected to database');
});



// =============================================================================


var bodyParser = require("body-parser");
var app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));


/**********************************************
				ROUTER for API
***********************************************/
var router = express.Router(); // get an instance of the express Router

// welcome message (accessed at GET http://localhost:8080/)
app.get('/', function (req, res) {
  res.send('Please use the URL: <a href="/api/v1">/api/v1</a>');
});

// welcome message (accessed at GET http://localhost:8080/api)
app.get('/api', function (req, res) {
  res.send('Please use the URL: <a href="/api/v1">/api/v1</a>');
});

// all of our routes will be prefixed with /api/v1
app.use('/api/v1', router);

// welcome message (accessed at GET http://localhost:8080/api/v1)
router.get('/', function(req, res) {
	res.send('<h1>Welcome to REST API v1!</h1>');
	//res.json({ message: 'Welcome to REST API v1!' });   
});


/**********************************************
				ROUTER for DAYS
***********************************************
GET		/days 		Retrieves a list of days
GET		/days/566	Retrieves a specific day #566
POST	/days		Creates a new day
PUT		/days/12	Updates day #566
DELETE	/days/12	Deletes day #566

*/
router.get('/days', weather.findAll);
router.get('/days/:idDay', weather.findById);
router.post('/days', weather.add);
router.put('/days/:idDay', weather.update);
router.delete('/days/:idDay', weather.delete);


/**********************************************
				Error handling
***********************************************/
app.use(function(err, req, res, next) {
  console.log(err.stack);
  console.log(JSON.stringify(err));
  res.send(
			{"errorMessages": ["ERROR"],
			"errors": err}
		);
});



//app.listen(8080);
//console.log('REST API listening on port 8080...');

var server = app.listen(process.env.PORT || '8080', function () {
  console.log('App listening on port %s', server.address().port);
  console.log('Press Ctrl+C to quit.');
});


