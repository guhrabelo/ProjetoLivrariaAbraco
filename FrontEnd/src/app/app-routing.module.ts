import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdmComponent } from './adm/adm.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { CategoriaComponent } from './categoria/categoria.component';
import { CompraComponent } from './compra/compra.component';
import { ContatoComponent } from './contato/contato.component';
import { CategoriaDeleteComponent } from './delete/categoria-delete/categoria-delete.component';
import { ProdutoDeleteComponent } from './delete/produto-delete/produto-delete.component';
import { CategoriaEditComponent } from './edit/categoria-edit/categoria-edit.component';
import { ProdutoEditComponent } from './edit/produto-edit/produto-edit.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LojaCategoriaComponent } from './loja-categoria/loja-categoria.component';
import { LojaComponent } from './loja/loja.component';
import { PagamentoComponent } from './pagamento/pagamento.component';
import { ProdutoComponent } from './produto/produto.component';
import { SobreNosComponent } from './sobre-nos/sobre-nos.component';

const routes: Routes = [

  {path: '', redirectTo: 'home', pathMatch: 'full'},

  {path: 'home', component: HomeComponent},
  {path: 'sobre-nos', component: SobreNosComponent},
  {path: 'contato', component: ContatoComponent},
  {path: 'loja', component: LojaComponent},
  {path: 'loja-categoria/:genero', component: LojaCategoriaComponent},
  
  {path: 'cadastro', component: CadastroComponent},
  {path: 'adm', component: AdmComponent},
  {path: 'login', component: LoginComponent},

  {path: 'categoria', component: CategoriaComponent},
  {path: 'produto', component: ProdutoComponent},
  {path: 'categoria-edit/:id', component: CategoriaEditComponent},
  {path: 'categoria-delete/:id', component: CategoriaDeleteComponent},
  {path: 'produto-edit/:id', component: ProdutoEditComponent},
  {path: 'produto-delete/:id', component: ProdutoDeleteComponent},
  {path: 'compra', component: CompraComponent},
  {path: 'compra/:id', component: CompraComponent},
  {path: 'pagamento', component: PagamentoComponent},
  {path: 'carrinho', component: CarrinhoComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
