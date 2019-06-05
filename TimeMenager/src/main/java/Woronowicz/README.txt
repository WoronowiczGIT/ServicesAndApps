

start  start work || show result

    start work
       - choose task
       - start task
       - finish task
       - back to choose task

    show results
       - daily time per task
       - monthly time per task

       Clock:
            measures time of start and finish

       TaskRepository:
            Holds a map of tasks paired with thier ID's

            reposnsible for adding, removing and modifing task list

       TaskManager:
            Handles Tasks, responsible for selecting, starting, finishing and updating task, and then passing resaults to repository
