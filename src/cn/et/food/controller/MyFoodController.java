package cn.et.food.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.et.food.entity.Food;
import cn.et.food.entity.Result;
import cn.et.food.service.FoodService;
import cn.et.food.utils.PageTools;

@Controller
public class MyFoodController {
	@Autowired
	FoodService service;
	@ResponseBody
	@RequestMapping(value="/queryFoodList",method={RequestMethod.GET})
	public PageTools queryFood(@RequestParam(required=false)String foodname, Integer page,Integer rows){
		return service.queryFood(foodname, page, rows);
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/food/{foodId}",method={RequestMethod.DELETE})
	public Result deleteFood(@PathVariable Integer foodId) throws Exception{
		Result res = new Result();
		try {
			service.deleteFood(foodId);
			res.setCode(1);
		} catch (Exception e) {
			res.setCode(0);
			res.setMessage(e);
		}
		return res;
	}
	/**
	 * 修改food
	 * @param foodId 菜品id
	 * @param foodName 菜品名
	 * @param price 菜品价格
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/food/{foodId}",method={RequestMethod.PUT})
	public Result udpateFood(@PathVariable Integer foodId,Food food) throws Exception{
		food.setFoodid(foodId);
		Result res = new Result();
		res.setCode(1);
		try {
			service.updateFood(food);
		} catch (Exception e) {
			res.setCode(0);
			res.setMessage(e);
		}
		return res;
	}
	/**
	 * 现在菜品
	 * @param foodName 菜品名称
	 * @param price 价格
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/food",method={RequestMethod.POST})
	public Result saveFood(Food food, MultipartFile myImage) throws Exception{
		Result res = new Result();
		res.setCode(1);
		try {
			String fileName=myImage.getOriginalFilename();
			File destFile=new File("E:/myImage/"+fileName);
			myImage.transferTo(destFile);
			service.saveFood(food);
		} catch (Exception e) {
			res.setCode(0);
			res.setMessage(e);
		}
		return res;
	}
}
