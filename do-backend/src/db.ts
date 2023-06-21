import { createConnection, ConnectionOptions, useContainer } from 'typeorm';
import { dbConfig } from './config/db';
import Container from 'typedi';

export async function createDatabaseConnection(): Promise<void> {
  try {
    const connectionOpts: ConnectionOptions = {
      type: 'mysql',
      host: dbConfig.dbHost,
      port: dbConfig.dbPort,
      username: dbConfig.dbUsername,
      password: dbConfig.dbPassword,
      database: dbConfig.dbDatabase,
      synchronize: false,
      logging: true,
      entities: [__dirname + '/entity/*.entity.{js,ts}'],
    };
    console.log([__dirname + '/entity/*.entity.{js,ts}']);

    useContainer(Container);
    await createConnection(connectionOpts);
  } catch (error) {
    throw error;
  }
}
