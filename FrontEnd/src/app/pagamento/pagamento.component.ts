import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { render } from 'creditcardpayments/creditCardPayments'
import { environment } from 'src/environments/environment.prod';
@Component({
  selector: 'app-pagamento',
  templateUrl: './pagamento.component.html',
  styleUrls: ['./pagamento.component.css']
})
export class PagamentoComponent implements OnInit {

  constructor(
    private router: Router
  ) {
  }

  ngOnInit() {

    if (environment.tipo == '') {
      this.router.navigate(['/home'])
    }

    render(
      {
        id: "#myPaypalButtons",
        currency: "BRL",
        value: "163.13",
        onApprove: (details) => {
          alert("Trlkajwklj")
        }
      }
    );

  }

}