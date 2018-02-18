/*
 * Copyright (C) 2018 Nitrogen OS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.resurrection.ota.tasks;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;

import com.resurrection.ota.tasks.CheckUpdateTask;
import com.resurrection.ota.utils.OTAUtils;

public class OTAService extends JobService {

    public boolean onStartJob(final JobParameters jobParameters) {

        CheckUpdateTask otaChecker = CheckUpdateTask.getInstance(true);
        if (!otaChecker.getStatus().equals(AsyncTask.Status.RUNNING)) {
            otaChecker.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, getApplicationContext());
        }

        return false;
    }




    @Override
    public boolean onStopJob(JobParameters jobParameters) {

        return false;

    }
}
