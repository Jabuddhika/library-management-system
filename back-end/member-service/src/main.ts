import express, {Express} from 'express';
import env from 'dotenv';
import {router as MembersRouter} from "./api/member-restcontroller";

env.config();

const app:Express=express();

app.use("/api/v1/members",MembersRouter)
app.listen(process.env.APP_PORT,()=>console.log("server is opened"));

