<template>
    <div class="dropdown">
        <ion-icon :class="'note__icon'" :name="icon" @click="closeHandler"></ion-icon>
        <ul  class="dropdown__list" v-if="isOpen"  v-on-clickaway="closeDrop">
            <slot></slot>
        </ul>
    </div>
</template>
<script>
    import { mixin as clickaway } from 'vue-clickaway';
    export default {
        mixins: [ clickaway ],
        name: "Dropdown",
        props: {
            icon: {
                type: String,
                required: true,
                default: 'ellipsis-vertical'
            }
        },
        data() {
            return {
                isOpen: false
            };
        },
        methods: {
            closeHandler: function() {
                this.isOpen = !this.isOpen;
            },

            closeDrop() {
                this.isOpen = false;
            },
        }
    };
</script>
<style lang="scss" scoped>
</style>
