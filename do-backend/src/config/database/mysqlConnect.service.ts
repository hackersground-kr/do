import { Injectable } from '@nestjs/common';
import { TypeOrmModuleOptions, TypeOrmOptionsFactory } from '@nestjs/typeorm';

@Injectable()
export class MysqlConnectService implements TypeOrmOptionsFactory {
  constructor() {}

  createTypeOrmOptions(): TypeOrmModuleOptions {
    return {
      type: 'mysql',
      host: 'dodo.mysql.database.azure.com',
      port: 3306,
      username: 'do',
      password: 'b1nd0108!',
      database: 'do',
      entities: [__dirname + '/../../**/**/*.entity{.ts,.js}'],
      synchronize: true,
      // logging: true,
    };
  }
}
