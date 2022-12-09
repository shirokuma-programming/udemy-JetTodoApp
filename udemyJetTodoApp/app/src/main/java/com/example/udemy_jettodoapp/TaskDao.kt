package com.example.udemy_jettodoapp

import androidx.room.*

@Dao
interface TaskDao {

    /** タスク追加 */
    @Insert
    fun insertTask(task: Task)

    /** タスク全件取得 */
    @Query("SELECT * FROM Task")
    fun loadAllTasks(): List<Task>

    /** タスク更新 */
    @Update
    fun updateTask(task: Task)

    /** タスク削除 */
    @Delete
    fun deleteTask(task: Task)
}