import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import { ValidationPipe } from '@nestjs/common';
import { ErrorFilter } from './global/filter/error.filter';
import { LoggingInterceptor } from './global/interceptor/logging.interceptor';
import { config } from './config/config';

async function bootstrap() {
  const app = await NestFactory.create(AppModule, {
    bodyParser: true,
    cors: true,
  });
  app.useGlobalPipes(new ValidationPipe());
  app.useGlobalFilters(new ErrorFilter());
  app.useGlobalInterceptors(new LoggingInterceptor());
  const port: number = config.port;
  await app.listen(port);
}
bootstrap();
