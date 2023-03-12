import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { ToastrService } from 'ngx-toastr';
import { Category } from '../model/food/category';
import { Food } from '../model/food/food';
import { ImgFood } from '../model/food/img_food';
import { User } from '../model/user/user';
import { TokenService } from '../service/account/token.service';
import { FoodServiceService } from '../service/food/food-service.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {


  user: User;
  rfFood: FormGroup;
  food: Food[];
  imageFood: ImgFood[];
  category: Category[];
  name: string = "";
  id: number;
  error: string;
  checkNumber: number;
  checkLogged = false;
  accountRole: string;

  constructor(
    private _foodService: FoodServiceService,
    private _toast: ToastrService,
    private _title: Title,
    private _formBuilder : FormBuilder,
    private _tokenService: TokenService
  ) {
    this._title.setTitle("Menu")
  }

  ngOnInit(): void {
    this.user =  JSON.parse(this._tokenService.getUser())
    console.log(this.user);
    
    this._foodService.findAllFood(this.name).subscribe((data) => {
      this.food = data;
    });
    this._foodService.findImageFood(this.id).subscribe((data) => {
      this.imageFood = data;
    });
    this._foodService.findAllCategory().subscribe((data) => {
      this.category = data;
    });
    this.getFormOrder();
  }

  searchAll() {
    this._foodService.findAllFood(this.name).subscribe(
      (data) => {
        this.food = data;
      },
      (error) => {
        this._toast.error("Không tìm thấy món ăn nào phù hợp");
      }
    );
  }

  getFormOrder(){
    this.rfFood = this._formBuilder.group({
      idFood:[],
      idUser:[this.user.id],
      quantity:[1]
    });
  }

  showImage(id: number) {
    this.checkNumber = id;
    this._foodService.findImageFood(id).subscribe((data => {
      this.imageFood = data;
    }))
  }
  order(idFood){
    this.rfFood.patchValue({idFood: idFood});
    console.log(this.rfFood.value);
    this._foodService.order(this.rfFood.value).subscribe((data=>{
    }))
  }
}
