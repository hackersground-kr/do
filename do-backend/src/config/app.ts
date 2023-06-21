import 'dotenv/config';

export const appConfig: appConfigType = {
  port: Number.parseInt(process.env.PORT),
};

interface appConfigType {
  port: number;
}
