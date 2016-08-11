/*
201 -> Created successfully
400 -> Errors
204 -> Updated/Removed successfully
*/

var Weather = require('../models/weather');

//GET		/days 	Retrieves a list of days
exports.findAll = function(req, res) {
	console.log('Retrieving all days...');
	Weather.find() 
	.exec(function (err, ret) {
		if (err) return res.status(400).send(err);
			//console.log(JSON.stringify(ret, null, "\t"))
			return res.send(ret);
	});
};


//GET		/days/12	Retrieves a specific day
exports.findById = function(req, res) {
    var idDay = req.params.idDay;
    console.log('Retrieving Day: ' + idDay);

	Weather.findOne({ 'dia': idDay })
     .exec(function(err, obj){
          if (err) return res.status(400).send(err);
		  //console.log(JSON.stringify(obj));
		  return res.send(obj);
     })
	 
};


//POST	/days		Creates a new day
exports.add = function(req, res) {
    var toAdd = req.body;
    console.log('Adding day: ' + JSON.stringify(toAdd));
    
	Weather.create(toAdd, function (err, board) {
		if (err) return res.status(400).send(err);
		return res.status(201).send(board);
		
	});
};



//PUT		/days/12	Updates day #12
exports.update = function(req, res) {
    var id = req.params.idDay;
    var toUpdate = req.body;
    console.log('Updating day: ' + id);
    console.log(JSON.stringify(toUpdate));

	
	Weather.findOneAndUpdate({ 'dia': id }, toUpdate)
     .exec(function(err, obj){
          if (err) return res.status(400).send(err);
		  //console.log(JSON.stringify(obj));
		  return res.send(obj);
     });
	 
	
};



//DELETE	/days/12	Deletes day #12
exports.delete = function(req, res) {
    var id = req.params.idDay;
    console.log('Deleting day: ' + id);
	
	Weather.findOneAndRemove( { 'dia': id } ,
		function (err, ret) {
		  if (err) return res.status(400).send(err);
		  return res.sendStatus(204);
		}
	);
 
};



