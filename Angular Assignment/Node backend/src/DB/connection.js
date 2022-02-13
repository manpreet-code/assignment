const mongoose=require("mongoose");

mongoose.connect('mongodb://localhost/blog', {
    useNewUrlParser: true, useUnifiedTopology: true, useCreateIndex: true
  }).then(()=>{
      console.log(`db connected`);
  }).catch((e)=>{
    console.log(`db not connected`);
  })