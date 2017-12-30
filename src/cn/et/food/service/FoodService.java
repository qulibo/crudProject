package cn.et.food.service;


import cn.et.food.entity.Food;
import cn.et.food.utils.PageTools;

public interface FoodService {
	
	public abstract PageTools queryFood(String foodname, Integer page, Integer rows);
	
	public abstract void deleteFood(Integer foodId);

	/* (non-Javadoc)
	 * @see cn.et.food.dao.impl.MyFoodDao#saveFood(s, java.lang.String)
	 */
	public abstract void saveFood(Food food);

	/* (non-Javadoc)
	 * @see cn.et.food.dao.impl.MyFoodDao#updateFood(java.lang.String, java.lang.String, java.lang.String)
	 */
	public abstract void updateFood(Food food);
	
}