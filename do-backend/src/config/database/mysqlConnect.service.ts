import { Injectable } from '@nestjs/common';
import { TypeOrmModuleOptions, TypeOrmOptionsFactory } from '@nestjs/typeorm';
import { config } from '../config';

@Injectable()
export class MysqlConnectService implements TypeOrmOptionsFactory {
  constructor() {}

  createTypeOrmOptions(): TypeOrmModuleOptions {
    return {
      type: 'mysql',
      host: config.DBHost,
      port: config.DBPort,
      username: config.DBUsername,
      password: config.DBPassword,
      database: config.DBDatabase,
      entities: [__dirname + '/../../**/**/*.entity{.ts,.js}'],
      synchronize: true,
      // logging: true,
    };
  }
}
