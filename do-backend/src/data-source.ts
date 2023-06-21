import 'reflect-metadata';
import { DataSource } from 'typeorm';
import { Member } from './entity/Member';
import { dbConfig } from './config/db';

export const AppDataSource = new DataSource({
  type: 'mysql',
  host: dbConfig.dbHost,
  port: dbConfig.dbPort,
  username: dbConfig.dbUsername,
  password: dbConfig.dbPassword,
  database: dbConfig.dbDatabase,
  synchronize: true,
  logging: false,
  entities: [Member],
  migrations: [],
  subscribers: [],
});
