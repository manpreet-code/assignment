const express = require('express');
const Article=require("../models/blog");
const router = express.Router();
router.get("/",async(req,res)=>{
    try {
        const getArtical = await Article.find({});
    res.status(201).send(getArtical);
    } catch (error) {
        res.status(400).send(error);
        
    }
})
router.get("/:id",async(req,res)=>{
    try {
        const _id= req.params.id;
        const getArtical = await Article.findById(_id);
    res.status(201).send(getArtical);
    } catch (error) {
        res.status(400).send(error);
        
    }
})
router.patch("/:id",async(req,res)=>{
    try {
        const _id= req.params.id;
        const getArtical = await Article.findByIdAndUpdate(_id,req.body,{
            new:true
        });
    res.status(201).send(getArtical);
    } catch (error) {
        res.status(500).send(error);
        
    }
})
router.delete("/:id",async(req,res)=>{
    try {
        const _id= req.params.id;
        const getArtical = await Article.findByIdAndDelete(_id);
    res.status(201).send(getArtical);
    } catch (error) {
        res.status(500).send(error);
        
    }
})
router.post("/",async(req,res)=>{
    try {
        let addNewArtical=new Article(req.body);
        const newArtical = await addNewArtical.save();
    res.status(201).send(newArtical);
    } catch (error) {
        res.status(400).send(error);
        
    }
})
module.exports=router;