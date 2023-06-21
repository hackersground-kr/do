import { Entity, PrimaryGeneratedColumn, Column } from 'typeorm';

@Entity()
export class Member {
  @PrimaryGeneratedColumn()
  id: number;

  @Column({
    name: 'name',
    nullable: false,
  })
  name: string;

  @Column({
    name: 'x_address',
    nullable: false,
  })
  xAddress: string;

  @Column({
    name: 'y_address',
    nullable: false,
  })
  yAddress: number;

  @Column({
    name: 'pdf_url',
    nullable: false,
  })
  pdfUrl: string;

  @Column({
    name: 'summary',
    nullable: false,
  })
  summary: string;
}
