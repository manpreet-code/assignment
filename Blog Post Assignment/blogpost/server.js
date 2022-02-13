const express= require("express");
const mongoose=require("mongoose");
const articleRouter = require("./routers/article");
const artical = require("./models/artical");
const User= require("./models/user");
const methodOverride = require('method-override');
const app = express();
mongoose.connect('mongodb://localhost/blog', {
    useNewUrlParser: true, useUnifiedTopology: true, useCreateIndex: true
  })
  app.use(express.urlencoded({ extended: false }));
app.set("view engine","ejs");
app.use(methodOverride('_method'));

app.get("/",(req,res)=>{
    res.render("login",{message:null});
})
app.post("/login",async(req,res)=>{
    try {
        let message=null;
    const user=  await User.findOne({username: req.body.username});
    if(user){
    if(user.password!=req.body.password){
        message="password not correct";
        res.render("login",{message:message});

    }
    if(user.password===req.body.password){
        res.redirect("/articles"); 
    }}else{
        message="user does not exist";
        res.render("login",{message:message});
    }
    } catch (error) {
        console.log(error);
        
    }
    
})
app.use('/articles', articleRouter);

app.get("/signup",(req,res)=>{
    res.render("signup",{messages:null});
})
app.post("/signup",async(req,res)=>{
    try {
    if(req.body.password!=req.body.ConfirmPassword){
       let messages="password do not match";
        res.render("signup",{messages:messages})
    }
    let user= new User({
        username:req.body.username,
        password:req.body.password,
    })
    
        await user.save();
        res.redirect("/");
    } catch (error) {
      console.log(error);  
    }
})
 app.listen(5000);
 