<template>
    <li class="dropdown__item" @click="startAction">
        <ion-icon :class="['dropdown__item__icon', colorClass]" :name="icon"></ion-icon> {{ name }}
    </li>
</template>
<script>
    export default {
        name: "DropdownItem",
        props: {
            name: {
                type: String,
                required: true
            },
            icon: {
                type: String,
                required: false,
            },
            colorClass: {
                type: String,
                required: false,
            }
        },
        methods: {
            startAction: function () {
                this.$parent.closeHandler();
                this.$emit('action')
            }
        }
    };
</script>
<style lang="scss" scoped>
    .pencil-outline_yellow {
        color: #FFC107;
    }
    .close-outline_red {
        color: red;
    }
</style>
