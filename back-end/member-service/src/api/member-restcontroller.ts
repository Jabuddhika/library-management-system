import express, {json, Router} from 'express';
import cors from 'cors';
import {Collection, Db, MongoClient} from "mongodb";
import env from 'dotenv';
import {stat, Stats} from "fs";
import {Member} from "../dto/member";
import {constants} from "http2";
import {constants} from "os";
import errno = module







env.config();

export const router:Router=express.Router();

router.use(cors());
router.use(json());
const mongo=new MongoClient(process.env.APP_DB_URL!)
let memberRepo:Collection<Document>
async function main() {
    await mongo.connect();
    console.log('Connected successfully to server');
    memberRepo=mongo.db(process.env.APP_DB_NAME).collection('member');

}
main();

function validateMember(member:Member){
    const validationErrors:Array<{field:string,error:string}>=[];


    if(!member._id?.trim())
        validationErrors.push({field:"data validation",error:"member id cant be empty"})
    if(!/^\d{9}[Vv]$/.test(member._id))
        validationErrors.push({field:"data validation",error:"invalid id"})

    if(!member.name?.trim())
        validationErrors.push({field:"data validation",error:"member name cant be empty"})
    if(!/^[A_Za-z ]*$/.test(member.name))
        validationErrors.push({field:"data validation",error:"invalid name"})

    if(!member.address?.trim())
        validationErrors.push({field:"data validation",error:"address name cant be empty"})

    if(!member.contact?.trim())
        validationErrors.push({field:"data validation",error:"member contact cant be empty"})
    if(!/^\d{3}-\d{7}$/.test(member.contact))
        validationErrors.push({field:"data validation",error:"invalid contact"})


}

router.post("/",async(req, res)=>{
  try {
      const member:Member=await req.body as Member;






      await memberRepo.insertOne(req.body);
     res.sendStatus(201);


  }catch (e:any){
      if(e.name && e.name==="data validation"){
        res.status(400).json({
            "msg":e.message
        })
      }
  }



})

router.patch("/:memberId",(req, res)=>{

})

router.delete("/:memberId",(req, res)=>{
    res.send("<h1>delete member</h1>")
})

router.get("/:memberId",(req, res)=>{
    res.send("<h1>get member</h1>")
})

router.get("/",async(req, res)=>{
  res.json(await memberRepo.find({}).toArray());
})
