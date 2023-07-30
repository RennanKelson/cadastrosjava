import { IRegisterPerson } from "./register-person-model";

export interface ILoginRegister {
  usuario: string;
  senha: string;
  pessoa: IRegisterPerson;
}
