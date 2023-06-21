export const routingControllerOptions = {
  cors: true,
  controllers: [`${__dirname}/../controller/**/*.{js,ts}`],
  dto: [`${__dirname}/../dto/**/*.{js,ts}`],
  middlewares: [`${__dirname}/../middlewares/*.{js,ts}`],
  entities: [`${__dirname}/../entity/*.{js,ts}`],
  service: [`${__dirname}/../service/**/*.{js,ts}`],
  validation: false,
};
