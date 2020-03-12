<template>
    <div>
        <p v-if="error">ERROR: {{error}}</p>
        <table v-if="properties">
            <tr>
                <th>Name</th>
                <th>Value</th>
            </tr>
            <tr v-for="(value, name) in properties" :key="name">
                <td>{{name}}</td>
                <td>{{value}}</td>
            </tr>
        </table>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'SystemProperties',
    data() {
        return {
            properties: null,
            error: null
        }
    },
    mounted() {
        axios.get('/system/properties')
        .then(req => {
            this.properties = req.data;
            this.error = null;
        })
        .catch(error => {
            this.properties = null;
            this.error = error;
        })
    }

}
</script>

<style scoped>
    td, th {
        text-align: left;
    }
</style>