package com.example.udemy_jettodoapp

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    /** タスク追加 */
    @Insert
    suspend fun insertTask(task: Task)

    /** タスク全件取得 */
    @Query("SELECT * FROM Task")
    fun loadAllTasks(): Flow<List<Task>>

    /** タスク更新 */
    @Update
    suspend fun updateTask(task: Task)

    /** タスク削除 */
    @Delete
    suspend fun deleteTask(task: Task)
}