import 'dotenv/config';

export const dbConfig: dbConfigType = {
  dbHost: process.env.DB_HOST,
  dbPort: Number.parseInt(process.env.DB_PORT),
  dbDatabase: process.env.DB_DATABASE,
  dbUsername: process.env.DB_USERNAME,
  dbPassword: process.env.DB_PASSWORD,
  allowLogging: process.env.DB_LOGGING,
};

interface dbConfigType {
  dbHost: string;
  dbPort: number;
  dbDatabase: string;
  dbUsername: string;
  dbPassword: string;
  allowLogging: string;
}
