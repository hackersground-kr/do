import { AppDataSource } from './data-source';
import express, { Express } from 'express';
import cors from 'cors';
import morgan from 'morgan';
import 'dotenv/config';
import { appConfig } from './config/app';

AppDataSource.initialize()
  .then(async () => {
    console.log('Inserting a new user into the database...');
  })
  .catch((error: any) => console.log(error));

const app: express.Application = express();
const logger = morgan('dev');

app.use(logger);
app.use(cors());

const handleListening = (): void => {
  console.log(`✅ Server listenting on port http://localhost:${appConfig.port}`);
};

app.listen(appConfig.port, handleListening);
