package com.example.to_do_listapp

class TaskInfo {

    var etNewTaskTitle:String=""
    var etNewTaskCategory:String=""
    var etNewTaskDetail: String=""
    var etNewTaskTime:String=""
    var user:String=""
    constructor(
        etNewTaskTitle: String,
        etNewTaskCategory: String,
        etNewTaskDetail: String,
        etNewTaskTime: String,
        user: String
    ){
        this.etNewTaskTitle=etNewTaskTitle
        this.etNewTaskCategory=etNewTaskCategory
        this.etNewTaskDetail=etNewTaskDetail
        this.etNewTaskTime=etNewTaskTime
        this.user=user
    }
}