const express = require('express');
const artical=require('./../models/artical');
const router = express.Router();


router.get('/',async(req,res)=>{
    const articals= await artical.find();
    res.render("articles/index",{articals:articals});
})

router.get("/new",(req,res)=>{
    res.render("articles/new");
})

router.post('/', async (req, res, next) => {
    // req.article = new Article()
    next()
  }, saveArticleAndRedirect('new'))
  router.get("/articalView/:id",async(req,res)=>{
    let articales=await artical.findById(req.params.id);
    res.render("articles/articalView",{articales:articales});
})
router.delete("/articalView/:id",async(req,res)=>{
    try {
        await artical.findByIdAndDelete(req.params.id) 
    } catch (error) {
        console.log(error); 
    }
   
  res.redirect('/articles');
})
router.get('/edit/:id', async (req, res) => {
    const article = await artical.findById(req.params.id)
    res.render('articles/edit', { article: article })
  })
  router.put('/:id', async (req, res, next) => {
    req.article = await artical.findById(req.params.id)
    next()
  }, saveArticleAndRedirect('edit'))

  function saveArticleAndRedirect(path) {
    return async (req, res) => {
      let article = new artical({
        title:req.body.title,
        category:req.body.catagory,
        markdown:req.body.markdown,})
      try {
        article = await article.save()
        res.redirect(`/articles/articalView/${article.id}`)
      } catch (e) {
          res.send("its not working");
        // res.render(`articles/${path}`, { article: article })
      }
    }
  }
  









module.exports = router