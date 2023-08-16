import express, {json, Router} from 'express';
import cors from 'cors';

export const router:Router=express.Router();


router.use(cors());
router.use(json());


router.post("/",(req, res)=>{
    res.send("<h1>save member</h1>");
})

router.patch("/:memberId",(req, res)=>{
    res.send("<h1>update member</h1>")
})

router.delete("/:memberId",(req, res)=>{
    res.send("<h1>delete member</h1>")
})

router.get("/:memberId",(req, res)=>{
    res.send("<h1>get member</h1>")
})

router.get("/",(req, res)=>{
    res.send("<h1>find members</h1>")
})
