import { Categoria } from "./Categoria";

export class Produto{
    public id: number
    public nome: string
    public autor: string
    public preco: number
    public quantidade: number
    public imagem: string
    public categoria: Categoria
}