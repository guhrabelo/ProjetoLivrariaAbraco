import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';


@Component({
  selector: 'app-admnavbar',
  templateUrl: './admnavbar.component.html',
  styleUrls: ['./admnavbar.component.css']
})
export class AdmnavbarComponent implements OnInit {

  nome = environment.nome

  constructor(
    private router: Router
  ) { }

  ngOnInit(){
  }

  sair(){
    this.router.navigate(['/home'])
    environment.tipo = ''
    environment.id = 0
    environment.nome = ''
    environment.token = ''
  }

}
