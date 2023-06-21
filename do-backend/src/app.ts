import express from 'express';
import { useContainer as routingUseContainer, useExpressServer } from 'routing-controllers';
import Container from 'typedi';
import { routingControllerOptions } from './config/routing';
import path from 'path';
import 'dotenv/config';
import { createDatabaseConnection } from './db';

export class App {
  public app: express.Application;

  constructor() {
    this.app = express();
    this.setMiddlewares();
    this.setDatabase();
    this.setEnv();
  }

  private async setDatabase(): Promise<void> {
    try {
      await createDatabaseConnection();
      console.log('디비 성공');
    } catch (error) {
      console.log(error);
      console.log('디비 실패');
    }
  }

  private setMiddlewares(): void {
    this.app.use(express.urlencoded({ extended: true }));
    this.app.use(express.json());
  }

  private getHttpPort(): number {
    const portExpression = process.env.PORT;
    if (portExpression) {
      return Number(portExpression);
    }
    return 8000;
  }

  public async createExpressServer(): Promise<void> {
    try {
      routingUseContainer(Container);
      useExpressServer(this.app, routingControllerOptions);
      const port = this.getHttpPort();

      this.app.listen(port, () => {
        console.log(`Server Start, port: ${port}`);
      });
    } catch (error) {
      console.log(error);
    }
  }

  public async setEnv(): Promise<void> {
    if (process.env.NODE_ENV === 'development') {
      require('dotenv').config({
        path: path.join(__dirname, '../.env.development'),
      });
    } else if (process.env.NODE_ENV === 'production') {
      require('dotenv').config({
        path: path.join(__dirname, '../.env.production'),
      });
    }
  }
}
