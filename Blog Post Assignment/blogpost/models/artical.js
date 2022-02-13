const mongoose = require('mongoose')
const articleSchema = new mongoose.Schema({
    title: {
      type: String,
      required: true
    },
    category: {
      type: String
    },
    markdown: {
      type: String,
      required: true
    }});
    module.exports = mongoose.model('Article', articleSchema)