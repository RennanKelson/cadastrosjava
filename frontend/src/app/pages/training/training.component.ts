import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IRegisterPerson } from 'src/app/models/login/register/register-person-model';
import { PessoaService } from 'src/app/shared/services/pessoa/pessoa.service';
import { TrainingService } from 'src/app/shared/services/training/training.service';

@Component({
  selector: 'app-training',
  templateUrl: './training.component.html',
  styleUrls: ['./training.component.css']
})
export class TrainingComponent implements OnInit{

  idPerson: number;
  person: IRegisterPerson;

  constructor(private trainingService: TrainingService, private pessoaService: PessoaService, router: Router){
    this.idPerson = Number(localStorage.getItem('idPerson'));
    this.person = {
      nome: '',
      cpf: '',
      email: '',
      idade: 0
    }
  }



  ngOnInit(): void {
    this.findPersonById(this.idPerson);
  }


  findPersonById(id : number){
    this.pessoaService.findById(this.idPerson).subscribe((response) => {
      console.log(response);
      this.person = response;
    })
  }

}
