package com.techelevator.controller;

import com.techelevator.dao.WeeklyPlanDao;
import com.techelevator.model.DailyPlan;
import com.techelevator.model.Recipe;
import com.techelevator.model.WeeklyPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/weeklyplans")
public class WeeklyPlanController {
    @Autowired
    private WeeklyPlanDao weeklyPlanDao;

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public List<WeeklyPlan> getWeeklyMealPlanByUserId(@PathVariable int userId) {
        return weeklyPlanDao.getWeeklyMealPlanByUserId(userId);
    }

    @RequestMapping(path = "/weekly/{userId}", method = RequestMethod.POST)
    public WeeklyPlan createWeeklyMealPlan(@RequestBody WeeklyPlan weeklyPlan, @PathVariable int userId) {

        return weeklyPlanDao.createWeeklyMealPlan(weeklyPlan, userId);

    }

    @RequestMapping(path = "/{weeklyplanId}/{userId}", method = RequestMethod.DELETE)
    public void deleteWeeklyMealPlan(@PathVariable int userId, int weeklyplanId) {
        weeklyPlanDao.deleteWeeklyMealPlan(userId, weeklyplanId);
    }
    @RequestMapping(path="/{weeklyplanId}", method=RequestMethod.PUT)
    public WeeklyPlan modifyWeeklyMealPlan(@PathVariable int weeklyplanId, @RequestBody WeeklyPlan modifyweeklyPlan){
        return weeklyPlanDao.modifyWeeklyMealPlan(weeklyplanId,modifyweeklyPlan);
}

}
