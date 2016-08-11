var mongoose = require('mongoose'),
	Schema = mongoose.Schema;

/**
 * Weather Schema
 */
var WeatherSchema = new Schema({
  dia: 			{type : String, required : true, unique: true},  
  clima: 		{type : String, required : true},  
  updatedAt:	Date,
  createdAt: 	Date
});



/**
 * Events logs
 */
WeatherSchema.post('init', function(doc) {
  //console.log('%s has been initialized from the db', doc._id);
});
WeatherSchema.post('validate', function(doc) {
  //console.log('%s has been validated (but not saved yet)', doc._id);
});
WeatherSchema.post('save', function(doc) {
  var currentDate = new Date();
  this.updatedAt = currentDate;
  if (!this.createdAt)
    this.createdAt = currentDate;
  console.log('%s has been saved', doc._id);
});
WeatherSchema.post('remove', function(doc) {
  console.log('%s has been removed', doc._id);
});


module.exports = mongoose.model('Weather', WeatherSchema,'weather');

