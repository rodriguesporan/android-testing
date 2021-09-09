package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Create an active task
        val tasks = listOf<Task>(Task("title", "desc", false))

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check result
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_oneCompletedNoActive_returnsHundredZero() {
        val tasks = listOf<Task>(Task("title", "desc", true))

        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_twoCompletedThreeActive_returnsFourthSixth() {
        val tasks = listOf<Task>(
            Task("title complete", "desc", true),
            Task("title complete", "desc", true),
            Task("title active", "desc", false),
            Task("title active", "desc", false),
            Task("title active", "desc", false)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.activeTasksPercent, `is`(60f))
        assertThat(result.completedTasksPercent, `is`(40f))
    }
}