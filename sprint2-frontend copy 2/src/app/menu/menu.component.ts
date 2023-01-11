import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { ToastrService } from 'ngx-toastr';
import { Category } from '../model/food/category';
import { Food } from '../model/food/food';
import { ImgFood } from '../model/food/img_food';
import { FoodServiceService } from '../service/food/food-service.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

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
    private _title: Title
  ) {
    this._title.setTitle("Menu")
  }

  ngOnInit(): void {
    this._foodService.findAllFood(this.name).subscribe((data) => {
      this.food = data;
    });
    this._foodService.findImageFood(this.id).subscribe((data) => {
      this.imageFood = data;
    });
    this._foodService.findAllCategory().subscribe((data) => {
      this.category = data;
    });
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

  showImage(id: number) {
    this.checkNumber = id;
    this._foodService.findImageFood(id).subscribe((data => {
      this.imageFood = data;
    }))
  }
}
