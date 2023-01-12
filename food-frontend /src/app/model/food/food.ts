import { Category } from "./category";
import { ImgFood } from "./img_food";

export interface Food {
  id?: number;
  name?: string;
  price?: number;
  description?: string;
  avatarFood?: string;
  category?: Category;
  img_food?: ImgFood
}