import { IRegisterPerson } from "./register-person-model";

export interface ILoginRegister {
  id?: number;
  usuario: string;
  senha: string;
  pessoa: IRegisterPerson;
}
